/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $('#send').click(function(){
        $.ajax({
            type: "POST",
            url: 'SMSHandler',
            data:{
                area: $('#area_list').val()
                //location: $('#transformer_list').val(),
                //message: $('#message').val()
            },
            dataType: 'json',
            success: function(){
                
                alert('sendSMS');
            }
          
        });
    });
});
//$(document).ready(function () {
//    $('#reserve').click(function (event) {
//        $.ajax({
//            type: "POST",
//            url: 'Reservation',
//            data: {
//                tableType: $('#type').val(),
//                time: $('#time').val(),
//                numOfSeats: $('#seats').val(),
//                date: $('#date').val()
//            },
//            success: function (responseText) {
//                $('#reservationInfo').html(responseText);
//            }
//        });
//    });
//});