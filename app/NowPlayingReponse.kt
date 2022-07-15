data class NowPlayingReponse(
    val dates: DatesX,
    val page: Int,
    val results: List<ResultX>,
    val total_pages: Int,
    val total_results: Int
)