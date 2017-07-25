/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$(document).ready(function (){
    
    $('#transformer_list').selectpicker();
    
    $('#area_list').change(function(){
        
        $.ajax({
          type: "POST",
          url: "TransformerHandler",
          data: {
            area: $('#area_list').val()    
          },
          dataType:'json',
          success:function(data){

              var datalist ;
              for(var i=0; i<data['data'].length;i++){                
                  datalist += "<option value='" + data['data'][i] + "'>" + data['data'][i] + "</option>";
              }
              
              $('#transformer_list').html(datalist);
          }
         
       });
        
    });
    
    $('.selectpicker').on('change',function(){
       console.log($('.selectpicker').val());
       $.ajax({
          type: "POST",
          url: "TransformerHandler",
          data: {
            area: $('.selectpicker').val()    
          },
          dataType:'json',
          success:function(data){

              var datalist ;
              for(var i=0; i<data['data'].length;i++){  
                  console.log("<option value='" + data['data'][i] + "'>" + data['data'][i] + "</option>");
                  $('#transformer_list').append("<option value='" + data['data'][i] + "'>" + data['data'][i] + "</option>");
                  
              }
              $('#transformer_list').selectpicker('refresh');
//              $('#transformer_list').html(datalist);
//              $('.selectpicker').selectpicker('render');
          }
         
       });
    });
    
   $('#transformer').click(function (event){
 
        alert('asa');
//       $.ajax({
//          type: "POST",
//          url: "TransformerHandler",
//          data: {
//            
//                area: $('#area_list').val(),
//                transformer: $('#transformer_list').val()
//              
//          }
         
//       });
   }); 
});









