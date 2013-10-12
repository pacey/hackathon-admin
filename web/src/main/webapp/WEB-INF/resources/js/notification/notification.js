define(["backbone", "moment"], function(Backbone, moment){
	return Backbone.Model.extend({
		defaults: {
			type: "information",
			time: function(){
				return moment().format("dddd, MMMM Do YYYY h:mm:ss");
			}
		}
	});
});