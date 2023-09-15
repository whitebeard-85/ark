$(function(){
	$(document).on({
		ajaxStart: function() {
			waitingDialog.show('일하는중...');
		},
		ajaxStop : function() {
			$('#bootstrapWaitingforModal').modal('hide');
		}
	});
});

const common = {
	callAjax : function(method, url, data, callback) {
		$.ajax({
			type: method,
			async : false,
			url: url,
			data: JSON.stringify(data),
			contentType:"application/json", //charset=UTF-8 생략가능
			success: function(res){
				if(callback) {
					callback(res);
				}
			},
			error:function(res, status, error){
				location.href = '/error';
			}
		})
	},
	alert : function(contents, callback) {
        $('#alertModal').remove();
        var elem = $.parseHTML(
			'<div id="alertModal" class="modal fade" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">' +
                '<div class="modal-dialog modal-dialog-centered" role="document">' +
                  	'<div class="modal-content">' +
                    	'<div class="modal-header">' +
                      		'<h5 class="modal-title">알림!!</h5>' +
                      		'<button type="button" class="btn-close" id="btnClose" aria-label="Close"></button>' +
                    	'</div>' +
                    	'<div class="modal-body">' +
                      		contents +
                    	'</div>' +
                    	'<div class="modal-footer">' +
                      		'<button type="button" class="btn btn-primary" id="btnConfirm">확인</button>' +
                    	'</div>' +
                  	'</div>' +
                '</div>' +
       		'</div>'
        );
        $('body').append(elem);

		$("#alertModal #btnClose, #btnConfirm").off('click');
        $("#alertModal #btnClose, #btnConfirm").on('click', function() {
			$('#alertModal').modal('hide');
			if(callback) {
				callback();
			}
		})

        $('#alertModal').modal('show');
	}
}

jQuery.fn.serializeObject = function() {
    var obj = null;
    try {
        if (this[0].tagName && this[0].tagName.toUpperCase() == "FORM") {
            var arr = this.serializeArray();
            if (arr) {
                obj = {};
                jQuery.each(arr, function() {
                    obj[this.name] = this.value;
                });
            }//if ( arr ) {
        }
    } catch (e) {
        alert(e.message);
    } finally {
    }

    return obj;
};