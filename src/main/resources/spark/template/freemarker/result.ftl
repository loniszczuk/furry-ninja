<html>
<head>
<script src='quintus/lib/v0.2.0/quintus-all.js'></script>
<script src='javascripts/penalty-kicks-sprites.js'></script>
<script src='javascripts/penalty-kicks-scenes.js'></script>
</head>
<body>
	<script>
	var winner = "${getWinner()}";
	//player  moves
	var MOVE_CENTER = 0;
	var MOVE_RIGHT = 1;
	var MOVE_LEFT = -1;
	
	window.addEventListener("load", function() {
	
		var Q = window.Q = Quintus().include("Sprites, 2D, Scenes, Anim, UI, Input, Touch")
									.include("PenaltyKicksSprites, PenaltyKicksScenes")
									.setup({maximize : true}).touch();
		
		//Q.debug = true;
		//Q.debugFill = true;

		var kickerMoves = [];
		var goalieMoves = [];
	
	<#assign moveCount = 0>
	<#list  getPenalties() as penalty>
		<#assign moveCount = moveCount + 1>	
		kickerMoves[${moveCount}]=MOVE_${penalty.getKickPosition()};
		goalieMoves[${moveCount}]=MOVE_${penalty.getDivePosition()};
	</#list>
		Q.state.set("totalMoves", ${moveCount});
		Q.state.set("kickerMoves", kickerMoves);
		Q.state.set("goalieMoves", goalieMoves);
		Q.state.set("winner", "${getWinner()}");
		Q.state.set("nextMove", 1);
		
		Q.load("goalie_14x2.json, goalie_14x2.png, kicker_16x1.json, kicker_16x1.png, background.png", function() {
		    Q.compileSheets("goalie_14x2.png","goalie_14x2.json");
		    Q.compileSheets("kicker_16x1.png","kicker_16x1.json");
		    Q.animations("goalie", {
		      jump_right: { frames: [0,1,2,3,4,5,6,7,8,9,10,11,12,13], rate: 1/4, flip: false, loop: false},
		      jump_left: { frames: [27,26,25,24,23,22,21,20,19,18,17,16,15,14], rate: 1/4, flip: false, loop: false },
		      stand: { frames: [0,1,2,3,2,1,0,27,26,25,26,27,0], rate: 1/4, flip: false, loop: false },
		    });
		   Q.animations("kicker", {
		      shoot: { frames: [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15], rate: 1/5, flip: false, loop: false},
		      stand: { frames: [0,1,2], rate: 1/4, flip: false, loop: false },
		    });
		});
	
		Q.stageScene("start");
	});
	</script>
</body>
</html>