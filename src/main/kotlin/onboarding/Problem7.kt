package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    TODO("프로그램 구현")
}

private fun createFriendsMap(friendRelations: List<List<String>>, user: String): Map<String, List<String>> {
    val friendsMap = mutableMapOf<String, MutableList<String>>()

    friendRelations.forEach { relation ->
        val friendA = relation[0]
        val friendB = relation[1]

        friendsMap[friendA] = addFriend(friendsMap[friendA], user, friendB)
        friendsMap[friendB] = addFriend(friendsMap[friendB], user, friendA)
    }

    return friendsMap
}

private fun addFriend(friends: MutableList<String>?, user: String, newFriend: String): MutableList<String> {
    return (friends ?: mutableListOf()).apply {
        if (user != newFriend) {
            add(newFriend)
        }
    }
}

private fun getVisitCount(visitors: List<String>, userFriends: List<String>, user: String): Int =
    visitors.filterNot { visitor ->
        visitor in userFriends
    }.count { visitor ->
        visitor == user
    }

private fun String.getFriendsCount(friendsMap: Map<String, List<String>>): Int =
    (friendsMap[this] ?: mutableListOf()).size

private fun String.getFriendsOf(friendsMap: Map<String, List<String>>): List<String> {
    return friendsMap[this] ?: mutableListOf()
}