package chap12

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UserProfileFetcherTest {
    @Test
    fun `UserNameRepository 가 반환하는 이름이 ASSU1 이면, UserProfileFetcher 에서 UserProfile 을 가져왔을 때 이름이 ASSU1 이어야 한다`() {
        // Given
        val userProfileFetcher = UserProfileFetcher(
            userNameRepository = StubUserNameRepository(
                userNameMap = mapOf(
                    "0x1111" to "ASSU1",
                    "0x2222" to "ASSU2",
                ),
            ),
            userPhoneNumberRepository = FakeUserPhoneNumberRepository(),
        )

        // When
        val userProfile = userProfileFetcher.getUserProfileById("0x1111")

        // Then
        assertEquals("ASSU1", userProfile.name)
    }

    @Test
    fun `UserPhoneNumberRepository 에 휴대폰 번호가 저장되어 있으면, UserProfile 을 가져왔을 때 해당 휴대폰 번호가 반환되어야 한다`() {
        // Given
        val userProfileFetcher = UserProfileFetcher(
            userNameRepository = StubUserNameRepository(
                userNameMap = mapOf(
                    "0x1111" to "ASSU1",
                    "0x2222" to "ASSU2",
                ),
            ),
            userPhoneNumberRepository = FakeUserPhoneNumberRepository().apply {
                this.saveUserPhoneNumber("0x1111", "010-1111-2222")
            },
        )

        // When
        val userProfile = userProfileFetcher.getUserProfileById("0x1111")

        // Then
        assertEquals("010-1111-2222", userProfile.phoneNumber)
    }
}