package com.lucasfagundes.ioasysbooks.domain.exception

open class LoginException : Exception()

class InvalidEmailException : LoginException()
class InvalidPasswordException : LoginException()
