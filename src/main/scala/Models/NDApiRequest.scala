package Models

/**
 * Created by nikolatonkev on 15-04-22.
 */

import java.util.UUID

case class NDApiRequest[G] (
  AuthGuyd: UUID,
  DeviceUniqueId: UUID,
  data: G
)