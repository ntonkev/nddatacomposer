package Models

/**
 * Created by nikolatonkev on 15-04-22.
 */
import ErrorStatus._

case class NDApiResponse[G] (
  ErrorStatus: ErrorStatus,
  ErrorMessage: String,
  data: G
)