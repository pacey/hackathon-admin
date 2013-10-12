define(["marionette", "navigation/navLayout", "navigation/navItemCollectionView", "navigation/navItemCollection", "navigation/navItem"], function(Marionette, NavLayout, NavItemCollectionView, NavItemCollection, NavItem){
	return Marionette.Controller.extend({
		initialize: function(options){
			this.navigationRegion = options.navigationRegion;
			this.siteNavigationItems = new NavItemCollection([
				new NavItem({
					text: "Add idea",
					href: "#/idea/add",
					icon: "glyphicon-plus"
				}),
				new NavItem({
					text: "Idea list",
					href: "#/idea",
					icon: "glyphicon-list"
				})
			]);
			this.userNavigationItems = new NavItemCollection([
				new NavItem({
					text: "Login",
					href: "#/login",
					icon: "glyphicon-user"
				})
			]);
			this.navigationRegion.show(this._getLayout());
		},
		_getLayout: function(){
			var layout = new NavLayout();
			this.listenTo(layout, "render", function(){
				this._showContent(layout);
			}, this);
			return layout;
		},
		_showContent: function(layout){
			layout.siteNavigation.show(new NavItemCollectionView({
				collection: this.siteNavigationItems
			}));
			layout.userNavigation.show(new NavItemCollectionView({
				collection: this.userNavigationItems,
				right: true
			}));
		}
	});
});