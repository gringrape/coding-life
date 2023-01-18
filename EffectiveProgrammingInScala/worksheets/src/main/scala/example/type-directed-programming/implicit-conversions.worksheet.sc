// 목표
// - Json.obj API 개발
// 요구 조건
// - Json.obj("name" -> "Andrew", "age" -> 17) 과 같은 표현을 지원해야 함.
sealed trait Json
case class JObject(fields: (String, Json)*) extends Json
case class JString(value: String) extends Json
case class JInt(value: Int) extends Json

object Json:
  def obj(fields: (String, JsonField)*) =
    JObject(fields.map((key, value) => (key, value.json))*)
  end obj

  case class JsonField(json: Json)

  object JsonField:
    given fromString: Conversion[String, JsonField] with
      def apply(s: String) = JsonField(JString(s))
    given fromInt: Conversion[Int, JsonField] with
      def apply(v: Int) = JsonField(JInt(v))

end Json

Json.obj("name" -> "Andrew", "age" -> 17)
Json.obj("name" -> "Hi", "age" -> 556)

// 배운 것
// - Pair 타입 정의 A -> B

// 햇갈리는 것
// - Json, JsonField
