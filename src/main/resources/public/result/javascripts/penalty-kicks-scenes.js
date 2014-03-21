;Quintus.PenaltyKicksScenes = function(Q) {
	
	var goalie;
	var kicker;
	var ball;

	Q.scene("players", function(stage) {
		//setting game state
		Q.state.set("goal", false);
		Q.state.set("readyToKick",true);
		//setting scene
		Q.clearStage();
		stage.insert(new Q.Background({type: Q.SPRITE_UI}));
		stage.insert(new Q.Goal());
		kicker = stage.insert(new Q.Kicker());
		ball = stage.insert(new Q.Ball({direction: Q.state.get("kickerMoves")[Q.state.get("nextMove")]}));
		goalie = stage.insert(new Q.Goalie({direction: Q.state.get("goalieMoves")[Q.state.get("nextMove")]}));
	});

	Q.scene('start',function(stage) {
		  var box = stage.insert(new Q.UI.Container({x: Q.width/2, y: Q.height/2, fill: "rgba(0,0,0,0.5)"}));
		  var button = box.insert(new Q.UI.Button({ x: 0, y: 0, fill: "#CCCCCC",label: "Go!" }))         
		  var label = box.insert(new Q.UI.Text({x:10, y: -50 - button.p.h, label:"Player1" }));
		  var label = box.insert(new Q.UI.Text({x:10, y: -30 - button.p.h, label:"vs" }));
		  var label = box.insert(new Q.UI.Text({x:10, y: -10 - button.p.h, label:"Player2" }));
		  button.on("click",function() {
			console.log("click");
		    Q.clearStages();
		    Q.stageScene('players');
		  });
		  box.fit(20);
		});
	
	
	Q.scene('nextMove',function(stage) {
	  var box = stage.insert(new Q.UI.Container({x: Q.width/2, y: Q.height/2, fill: "rgba(0,0,0,0.5)"}));
	  var button = box.insert(new Q.UI.Button({ x: 0, y: 0, fill: "#CCCCCC",label: "Next move!" }))         
	  var label = box.insert(new Q.UI.Text({x:10, y: -10 - button.p.h, label: stage.options.label }));
	  button.on("click",function() {
		console.log("click");
	    Q.clearStages();
	    setupNextMove();
	    Q.stageScene('players');
	  });
	  box.fit(20);
	});
	
	
	Q.scene('gameEnded',function(stage) {
		  var box = stage.insert(new Q.UI.Container({x: Q.width/2, y: Q.height/2, fill: "rgba(0,0,0,0.5)"}));
		  var button = box.insert(new Q.UI.Button({ x: 0, y: 0, fill: "#CCCCCC",label: "Continue" }))         
		  var label = box.insert(new Q.UI.Text({x:10, y: -10 - button.p.h, label: Q.state.get("winner") + " wins." }));
		  button.on("click",function() {
			console.log("click");
		    Q.clearStages();
		  });
		  box.fit(20);
		});
	
	function setupNextMove() {
		Q.state.set("nextMove", Q.state.get("nextMove") + 1);
		kicker.destroy();
		ball.destroy();
		goalie.destroy();
		Q.stageScene("players");
		kicker = stage.insert(new Q.Kicker({vy:-40}));
		ball = stage.insert(new Q.Ball({direction: Q.state.get("kickerMoves")[Q.state.get("nextMove")]}));
		goalie = stage.insert(new Q.Goalie({direction: Q.state.get("goalieMoves")[Q.state.get("nextMove")]}));
	} 
};