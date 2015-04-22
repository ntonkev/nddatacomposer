package Models

/**
 * Created by nikolatonkev on 15-04-22.
 */
object ErrorStatus extends Enumeration {
  type ErrorStatus = Value
  val None, NotAuthenticated, NotAutorized, BadAuthGuidFormat, MissingAuthGuid, MissingDevUniqueId, AuthExpired, UserExists, ErrorSavingData, ErrorGettingData = Value
}
import ErrorStatus._