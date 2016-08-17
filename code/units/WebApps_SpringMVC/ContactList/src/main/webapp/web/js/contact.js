$(function() { //this will just run once 
  loadContacts();

  $('#addButton').click(function() {
    $.ajax({
      type: 'POST',
      url: 'spring/rest/contact',
      data: JSON.stringify({
        firstName: $('#add-firstName').val(),
        lastName: $('#add-lastName').val(),
        company: $('#add-company').val(),
        phone: $('#add-phone').val(),
        email: $('#add-email').val()
      }),
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      'dataType': 'json'
    }).success(function(data, status) {
      $('#add-firstName').val('');
      $('#add-lastName').val('');
      $('#add-company').val('');
      $('#add-phone').val('');
      $('#add-email').val('');
      loadContacts();
    });

  });

  $('#editButton').click(function() {
    $.ajax({
      type: 'PUT',
      url: 'spring/rest/contact/' + $('#edit-contactId').val(),
      data: JSON.stringify({
        firstName: $('#edit-firstName').val(),
        lastName: $('#edit-lastName').val(),
        company: $('#edit-company').val(),
        phone: $('#edit-phone').val(),
        email: $('#edit-email').val(),
        contactId: $('#edit-contactId').val()
      }),
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      'dataType': 'json'
    }).success(function(data, status) {
      $('#edit-firstName').val('');
      $('#edit-lastName').val('');
      $('#edit-company').val('');
      $('#edit-phone').val('');
      $('#edit-email').val('');
      $('#edit-contactId').val('');
      loadContacts();
    });
  });

});

function deleteContact(element) {
  $.ajax({
    type: 'DELETE',
    url: 'spring/rest/contact/' + element.id
  }).success(function(status) {
    loadContacts();
  });

}

function getContact(element) {
  $.ajax({
    url: 'spring/rest/contact/' + element.id
  }).success(function(data) {
    $('#detail-firstName').text('First name: ' + data.firstName);
    $('#detail-lastName').text('Last name: ' + data.lastName);
    $('#detail-company').text('Company: ' + data.company);
    $('#detail-phone').text('Phone: ' + data.phone);
    $('#detail-email').text('Email: ' + data.email);

  });

}

function getEditContact(element) {
  $.ajax({
    url: 'spring/rest/contact' + element.id
  }).success(function(data) {
    $('#edit-firstName').val(data.firstName);
    $('#edit-lastName').val(data.lastName);
    $('#edit-company').val(data.company);
    $('#edit-phone').val(data.phone);
    $('#edit-email').val(data.email);
    $('#edit-contactId').val(data.contactId);
  });
}



function loadContacts() {
  $('#contact-list').empty(); //empties our #contact-list div
  $.ajax({
    url: "spring/rest/contacts" // there are   no parameters
  }).success(function(data, status) {//if successful then print each contact in the contacts list
    $.each(data, function(index, contact) {
      $('#contact-list').append(
              '<p class="row col-md-12">' +
              // call the method getContact() and then stop (return false)
              '<a class="col-md-6" onclick="getContact(this);" href="#" id="' +
              contact.contactId + '">' +
              contact.firstName + ' ' + contact.lastName +
              '</a><a class="col-md-offset-1 col-md-0" onclick="getContact(this);" href="#" id="' +
              contact.contactId +
              '">Edit</a> | <a class="col-md-offset-0"  onclick="getContact(this);" href="#" id="' +
              contact.contactId + '">Delete</a>' +
              '</p>'
              );
    });
  });
}