package nl.zwennesm.k8s.core

import com.autodsl.annotation.AutoDsl
import io.fabric8.kubernetes.api.model.Quantity
import io.fabric8.kubernetes.api.model.ResourceRequirements

@AutoDsl
class Resource(cpu: String, memory: String) : ResourceRequirements(
    mapOf("cpu" to Quantity(cpu), "memory" to Quantity(memory)),
    mapOf("cpu" to Quantity(cpu), "memory" to Quantity(memory))
)