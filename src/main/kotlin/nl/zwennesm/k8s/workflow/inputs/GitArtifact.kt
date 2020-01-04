package nl.zwennesm.k8s.workflow.inputs

import com.autodsl.annotation.AutoDsl

@AutoDsl
data class GitArtifact(
    val name: String,
    val path: String,
    val git: GitRepository
)