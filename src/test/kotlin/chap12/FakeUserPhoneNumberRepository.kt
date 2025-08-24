package chap12

class FakeUserPhoneNumberRepository: UserPhoneNumberRepository {
    private val userPhoneNumberMap = mutableMapOf<String, String>()

    override fun saveUserPhoneNumber(id: String, phoneNumber: String) {
        userPhoneNumberMap[id] = phoneNumber
    }

    override fun getPhoneNumberById(id: String): String {
        return userPhoneNumberMap[id] ?: ""
    }
}