//package com.webflux.springwebflux.services
//
//
//import com.webflux.springwebflux.utils.GeneralResponse1
//import org.springframework.beans.factory.annotation.Autowired
//import com.webflux.springwebflux.repos.Usersrepo
//import com.webflux.springwebflux.utils.GeneralRequest
//import com.webflux.springwebflux.entities.Users
//import reactor.core.publisher.Flux
//import org.springframework.http.HttpStatus
//import org.springframework.stereotype.Service
//
//@Service
//class TextJava {
//   lateinit var response: GeneralResponse1
//
//    @Autowired
//    private lateinit var usersrepo: Usersrepo
//    fun login(request: GeneralRequest<Users>): Flux<GeneralResponse1> {
//        response = GeneralResponse1()
//        val users = usersrepo.findByUsername(request.payload.username)
//        if (users != null) {
//            return users.map { u: Users? ->
//                response.setMessage("Success")
//                response.setReponsePayload(u)
//                response.setStatus(HttpStatus.ACCEPTED)
//                response
//            }
//        }
//        response.setStatus(HttpStatus.NOT_FOUND)
//        response.setMessage("Invalid login Credentialas")
//        response.setReponsePayload(null)
//        return response
//    }
//}
//
//
//
////@Service
////public class TextJava {
////    GeneralResponse1 response;
////    @Autowired
////    private Usersrepo usersrepo;
////
////    public Flux<GeneralResponse1> login(GeneralRequest<Users> request) {
////        response = new GeneralResponse1();
////        Flux<Users> users = usersrepo.findByUsername(request.getPayload().getUsername());
////        if (users != null) {
//            return users.map(u -> {
//                response.setMessage("Success");
//                response.setReponsePayload(u);
//                response.setStatus(HttpStatus.ACCEPTED);
//                return response;
//            });
////        }
////        response.setStatus(HttpStatus.NOT_FOUND);
////        response.setMessage("Invalid login Credentialas");
////        response.setReponsePayload(null);
////        return response;
////    }
////}