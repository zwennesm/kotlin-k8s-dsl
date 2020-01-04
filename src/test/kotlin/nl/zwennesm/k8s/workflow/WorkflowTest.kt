package nl.zwennesm.k8s.workflow

import com.fkorotkov.kubernetes.newContainer
import com.fkorotkov.kubernetes.newObjectMeta
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class WorkflowTest {

    @Test
    fun `workflow should have default attributes`() {
        val test = workflow {
            metadata = newObjectMeta {}
        }

        assertEquals("argoproj.io/v1alpha1", test.apiVersion)
        assertEquals("Workflow", test.kind)
    }

    @Test
    fun `workflow should throw error on missing metadata`() {
        assertThrows(IllegalStateException::class.java) {
            workflow {}
        }
    }

    @Test
    fun `workflow spec should have an entrypoint`() {
        assertThrows(IllegalStateException::class.java) {
            workflow {
                metadata = newObjectMeta {}
                spec {}
            }
        }
    }

    @Test
    fun `workflow spec entrypoint should point to an existing DAG or step`() {
        assertThrows(IllegalStateException::class.java) {
            workflow {
                metadata = newObjectMeta {}
                spec {
                    entryPoint = "non-existing"
                }
            }
        }
    }

    @Test
    fun `workflow spec onExit should point to an existing error DAG`() {
        assertThrows(IllegalStateException::class.java) {
            workflow {
                metadata = newObjectMeta {}
                spec {
                    entryPoint = "exists"
                    onExit = "non-existing"
                    templates = listOf(
                        workflowTemplate {
                            name = "exists"
                            container = newContainer { }
                        }
                    )
                }
            }
        }
    }

}