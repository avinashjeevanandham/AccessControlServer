package one.upswing.acs

import one.upswing.acs.models.ErrorCode


class ReservedRangeException(message: String, val detail: String): Exception(message) {
    val errorCode: ErrorCode = ErrorCode.VALUE_IN_THE_RESERVED_RANGE
}

class InvalidDataFormatException(message: String, val detail: String): Exception(message) {
    val errorCode: ErrorCode = ErrorCode.INVALID_DATA_FORMAT
}

