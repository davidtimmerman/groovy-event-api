var theObject = { firstName: "Julie", lastName : "Braem", email : "david.timmerman.mail@gmail.com", vat : "BE098098979" };


function register(){
$("#qcTcktForm").submit(function(){
        var $form = $(this);
        var viewArr = $form.serializeArray()
        var registration = {};

        for (var i in viewArr) {
            registration[viewArr[i].name] = viewArr[i].value;
          }
        $.ajax({
         type     : "PUT",
         cache    : false,
         url: "/event/1/register",
         data     : JSON.stringify(registration)
        })
    .done (function(data) { alert(data)   ;})
    .fail (function()  { alert("Error ")   ; })

     })
}