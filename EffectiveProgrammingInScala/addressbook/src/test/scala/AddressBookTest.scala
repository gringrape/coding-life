import org.scalatest.funspec.AnyFunSpec

case class Contact(name: String, phoneNumbers: List[String])

case class AddressBook(contacts: List[Contact]):
  val numberOfContacts = contacts.size

  val contactNames = contacts.map(contact => contact.name)

  val contactsWithPhone =
    contacts.filter(contact => contact.phoneNumbers.nonEmpty)

  def addContact(contact: Contact) =
    this.copy(contacts = contacts.appended(contact))

class CubeCalculatorTest extends AnyFunSpec:
  describe("AddressBook") {
    it("created without crash") {
      val alice = Contact(name = "Alice", phoneNumbers = List(""))
      val bob = Contact(name = "Bob", phoneNumbers = List(""))

      AddressBook(contacts = List(alice, bob))
    }

    describe("addContact") {
      it("increases number of contacts") {
        val addressBook = AddressBook(contacts = List())

        assert(addressBook.numberOfContacts === 0)

        val alice = Contact(name = "Alice", phoneNumbers = List(""))

        assert(addressBook.addContact(alice).numberOfContacts === 1)
      }
    }

    describe("contactNames") {
      it("get names in contacts") {
        val alice = Contact(name = "Alice", phoneNumbers = List(""))

        val addressBook = AddressBook(contacts = List(alice))

        val names = addressBook.contactNames
        assert(names(0) == alice.name)
      }
    }

    describe("contactsWithPhone") {
      it("filters contacts with phone number") {
        val alice = Contact(name = "Alice", phoneNumbers = List(""))
        val bob = Contact(name = "Bob", phoneNumbers = List("123-1234"))
        val jason = Contact(name = "Jason", phoneNumbers = List("456-4567"))

        val addressBook = AddressBook(contacts = List(alice, bob))

        val contacts = addressBook.contactsWithPhone
        assert(contacts.size == 2)
      }
    }
  }
