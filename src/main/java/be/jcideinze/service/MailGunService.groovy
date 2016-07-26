package be.jcideinze.service

import groovyx.net.http.HTTPBuilder

@Singleton
class MailGunService {

    void send(String email, String content) {
        final def http = new HTTPBuilder( 'https://api.mailgun.net/v3/sandboxe925c499eb854ca9a6c321fed766aaed.mailgun.org/messages' )
        http.auth.basic 'api', 'key-447eee0f00690f72e37d351b291a03a0'
        http.post(
                query:[
                        'from': 'no-reply@sandboxe925c499eb854ca9a6c321fed766aaed.mailgun.org',
                        'subject':'JCI Deinze Business Event',
                        'to':"$email",
                        'text':"$content"] ) { resp ->

            println "POST Success: ${resp.statusLine}"
            assert resp.statusLine.statusCode == 200
        }
    }
}
