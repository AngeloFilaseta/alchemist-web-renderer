import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldNotBe

class JvmTest : StringSpec(
    {
        "a simple jvm test" {
            true shouldNotBe false
        }
    }
)
