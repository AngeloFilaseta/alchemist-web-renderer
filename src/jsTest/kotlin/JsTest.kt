import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldNotBe

class JsTest : StringSpec(
    {
        "a simple js test" {
            true shouldNotBe false
        }
    }
)
