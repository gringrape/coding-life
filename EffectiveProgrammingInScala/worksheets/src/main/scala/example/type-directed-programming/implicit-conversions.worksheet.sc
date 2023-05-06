// #. 목표
// - Json.obj API 개발
// #. 요구 조건
// - Json.obj("name" -> "Andrew", "age" -> 17) 과 같은 표현을 지원해야 함.
// #. 실행
// - object Json, define obj
// - define JsonField
// - define Json => 객체 Json은 존재하지만 type이 정의되어 있지는 않다.
// - compiler가 JsonField 타입에 대한 적절한 객체를 가져오도록 함. => Conversion
// - conversion에서 변환하는 타입에 대해 주의.
// - String 타입을 JsonField 타입으로 변환해주는 메커니즘이 필요함. (given definition)
// - Int 타입을 JsonField 타입으로 변환해주는 메커니즘이 필요함. (given definition)

sealed trait Json
case class JString(value: String) extends Json
case class JInt(value: Int) extends Json
case class JObject(fields: (String, Json)*) extends Json

object Json:
  def obj(fields: (String, JsonField)*) =
    JObject(fields.map((key, value) => (key, value.json))*)

  case class JsonField(json: Json)

  object JsonField:
    given fromString: Conversion[String, JsonField] with
      def apply(value: String) = JsonField(JString(value))
    given fromInt: Conversion[Int, JsonField] with
      def apply(value: Int) = JsonField(JInt(value))

  end JsonField

end Json

Json.obj("name" -> "Andrew", "age" -> 17)
