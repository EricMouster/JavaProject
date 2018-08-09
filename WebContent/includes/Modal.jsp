<!-- Modal -->
<div class="modal fade" id="addIngredientModal" tabindex="-1"
	role="dialog" aria-labelledby="addIngredientModal" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Add an
					ingredient</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div id="alert" class="alert alert-danger" role="alert" style="display: none;">
				An error has occurred, please check the information you send.
			</div>
			<form method="post" action="/Recipe/MyIngredients"
				id="form-ingredient">
				<div class="modal-body">

					<div class="row">
						<div class="col">
							<div class="form-group">
								<label for="name">Name</label> <input type="text"
									class="form-control" id="name" name="name" placeholder="Eggs">
							</div>
						</div>
						<div class="col">
							<div class="form-group">
								<label for="unit">Unit</label> <input type="text"
									class="form-control" id="unit" name="unit" placeholder="Unity">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<div class="form-group">
								<label for="price">Price</label> <input type="number"
									class="form-control" id="price" name="price" step="0.01"
									placeholder="0.00">
							</div>
						</div>
						<div class="col"></div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
					<button
						id="adding"
						type="button" class="btn btn-primary"
						onclick="sendIngredient()"
						data-loading-text="<i class='fa fa-spinner fa-spin fa-fw' aria-hidden='true'></i>Sending"
						>Send</button>
				</div>
			</form>
		</div>
	</div>
</div>
<script>
var setLoading = function () {
  var search = $('#adding');
  if (!search.data('normal-text')) {
    search.data('normal-text', search.html());
  }
  search.html(search.data('loading-text'));
};

var clearLoading = function () {
  var search = $('#adding');
  search.html(search.data('normal-text'));
};
function sendIngredient() {
  setLoading();
  var name = $("#name")[0].value;
  var unit = $("#unit")[0].value;
  var price = $("#price")[0].value;
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      console.log(this.responseText);
      var response = JSON.parse(this.responseText);
      $("#ingredients-table").append('<th scope="row">'+response.id+'</th><td>'+response.name+'</td><td>'+response.price+'</td><td></td></tr>');
  	  $('#addIngredientModal').modal('hide');
      clearLoading();
    }
    if (this.readyState == 4 && this.status != 200) {
    	clearLoading();
    	$("#alert").show();
    }
  };
  xhttp.open("POST", "http://localhost:8080/Recipe/api/Ingredient/AddIngredient", true);
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send("name="+name+"&unit="+unit+"&price="+price); 
}
</script>