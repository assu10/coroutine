package chap12

class UserProfileFetcher(
    private val userNameRepository: UserNameRepository,
    private val userPhoneNumberRepository: UserPhoneNumberRepository,
) {
    fun getUserProfileById(id: String): UserProfile {
        // 유저 이름 조회
        val userName = userNameRepository.getNameByUserId(id)

        // 유저 전화번호 조회
        val userPhoneNumber = userPhoneNumberRepository.getPhoneNumberById(id)

        return UserProfile(
            id = id,
            name = userName,
            phoneNumber = userPhoneNumber,
        )
    }
}