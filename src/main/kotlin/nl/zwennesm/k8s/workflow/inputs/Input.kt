package nl.zwennesm.k8s.workflow.inputs

import com.autodsl.annotation.AutoDsl

@AutoDsl
data class Input(
    val artifacts: List<GitArtifact>
)