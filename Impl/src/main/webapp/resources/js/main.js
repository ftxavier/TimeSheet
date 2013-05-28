$(function() {
	$("#removeAll").click(function() {
		console.log("REMOVE ALL");
	});
	$("#remove").click(function() {
		console.log("REMOVE");
	});
	$("#addAll").click(function() {
		console.log("ADD ALL");
	});
	$("#add").click(function() {
		console.log("ADD");
	});
	
	$(".horaMask").mask("99:99");
	$(".dataMask").mask("99/99/9999");
});