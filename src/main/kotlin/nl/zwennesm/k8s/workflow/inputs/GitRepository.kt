package nl.zwennesm.k8s.workflow.inputs

import com.autodsl.annotation.AutoDsl

@AutoDsl
data class GitRepository(
    val repo: String,
    val revision: String,
    val sshPrivateKeySecret: PrivateKeySecret
)