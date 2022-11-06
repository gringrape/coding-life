// zip
case class Contact(name: String, maybeEmail: Option[String])

val alice = Contact(
  name = "Alice",
  maybeEmail = Some("aaa@alice")
)

val bob = Contact(
  name = "Alice",
  maybeEmail = Some("bbb@alice")
)

alice.maybeEmail.zip(bob.maybeEmail)
