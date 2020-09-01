package hhhirokunn.sampleapi.app.controller.model

//interface SampleApiResponse {
//    val status: Int
//}

//interface SampleApiDomainResponse: SampleApiResponse {
//    val data: SampleApiDomain?
//}

//interface SampleApiErrorResponse: SampleApiResponse {
//    val error: SampleApiError?
//}

//open class SampleApiDomainResponse(
//    override val status: Int = 200,
//    val data: SampleApiDomain?
//): SampleApiResponse
//
//open class SampleApiErrorResponse(
//    override val status: Int = 400,
//    val error: SampleApiError?
//): SampleApiResponse
//
//interface SampleApiError {
//    val domain: String
//    val method: String
//    val content: String
//}
//
//interface SampleApiDomain

interface SampleApiResponse<T> {
    val status: Int
    val data: T
}

interface DomainResponse
//interface ErrorResponse

//TODO 上限境界を指定
open class SampleApiDomainResponse<T>(
        override val status: Int = 200,
        override val data: T
): SampleApiResponse<T>

//TODO 上限境界を指定
open class SampleApiErrorResponse<T>(
        override val status: Int = 400,
        override val data: T
): SampleApiResponse<T>