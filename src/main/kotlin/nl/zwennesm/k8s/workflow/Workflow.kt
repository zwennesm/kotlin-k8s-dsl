package nl.zwennesm.k8s.workflow

import com.autodsl.annotation.AutoDsl
import com.fasterxml.jackson.annotation.JsonProperty
import io.fabric8.kubernetes.api.model.Container
import io.fabric8.kubernetes.api.model.ObjectMeta
import io.fabric8.kubernetes.api.model.apps.Deployment
import io.fabric8.kubernetes.api.model.apps.DeploymentSpec
import io.fabric8.kubernetes.api.model.apps.DeploymentStatus
import nl.zwennesm.k8s.workflow.inputs.Input

@AutoDsl
class Workflow(metadata: ObjectMeta, spec: WorkflowSpec?) :
    Deployment("argoproj.io/v1alpha1", "Workflow", metadata, spec, DeploymentStatus())

@AutoDsl
data class WorkflowSpec(
    val entryPoint: String,
    val onExit: String?,
    val templates: List<WorkflowStep>?
) : DeploymentSpec()

interface WorkflowStep {
    val name: String
}

@AutoDsl
data class WorkflowTemplate(
    override val name: String,
    val inputs: Input?,
    val container: Container
) : WorkflowStep

@AutoDsl
data class WorkflowDAG(
    override val name: String,
    val steps: List<WorkflowStepRule>
) : WorkflowStep

@AutoDsl
data class WorkflowStepRule(
    val name: String,
    val template: String,
    @JsonProperty("when")
    val rule: String
)