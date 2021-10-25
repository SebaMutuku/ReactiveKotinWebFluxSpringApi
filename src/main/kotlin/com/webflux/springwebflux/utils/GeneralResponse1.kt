//package com.webflux.springwebflux.utils
//
//import lombok.ToString
//import reactor.core.publisher.Flux
//import com.webflux.springwebflux.utils.GeneralResponse1
//import lombok.Getter
//import lombok.Setter
//import org.springframework.http.HttpStatus
//import reactor.core.CoreSubscriber
//
//@ToString
//@Setter
//@Getter
//class GeneralResponse1 : Flux<GeneralResponse1?>() {
//    var reponsePayload: Any? = null
//    var status: HttpStatus? = null
//    var message: String? = null
//    override fun subscribe(coreSubscriber: CoreSubscriber<in GeneralResponse1?>) {}
//}