package nl.zwennesm.k8s.workflow.inputs

import com.autodsl.annotation.AutoDsl

@AutoDsl
data class PrivateKeySecret(
    val name: String,
    val key: String
)