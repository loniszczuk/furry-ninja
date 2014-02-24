<html>
<head>
<!-- Pull the engine from the Quintus CDN or load it locally -->
<!-- (use quintus-all.min.js for production) -->
<script src='http://cdn.html5quintus.com/v0.2.0/quintus-all.js'></script>
</head>
<body>
	<script>
		window.addEventListener("load", function() {

			var Q = window.Q = Quintus().include("Sprites, 2D, Scenes").setup({
				maximize : true
			});

			Q.Sprite.extend("Goal", {
				draw : function(ctx) {
					ctx.fillStyle = "black";
					ctx.beginPath();
					ctx.fillRect(150, 30, 10, 50);
					ctx.fillRect(150, 30, 250, 10);
					ctx.fillRect(400, 30, 10, 50);
				}
			});

			Q.MovingSprite.extend("AbstractBall", {
				stop : function() {
					this.p.vx = 0,
					this.p.vy = 0
				},
				draw : function(ctx) {
					ctx.fillStyle = this.p.color;
					ctx.beginPath();
					ctx.arc(-this.p.cx, -this.p.cy, this.p.w / 2, 0,
							Math.PI * 2);
					ctx.fill();
				}
			});

			Q.AbstractBall.extend("Ball", {
				init : function(p) {
					this._super(p, {
						color : "black",
						w : 20,
						h : 20,
						x : 285,
						y : 300
					});
				},
				moveToTarget: function() {
					this.p.vy = -60;
					this.p.vx = 25 * this.p.target;
				}
			});

			Q.AbstractBall.extend("Player1", {
				init : function(p) {
					this._super(p, {
						color : "red",
						w : 50,
						h : 50,
						x : 300,
						y : 380
					});
				}
			});

			Q.AbstractBall.extend("Player2", {
				init : function(p) {
					this._super(p, {
						color : "green",
						w : 50,
						h : 50,
						x : 300,
						y : 100
					});
				}
			});

			var goal = new Q.Goal();
			var ball;
			var player1;
			var player2;
			
			Q.scene("move1", function(stage) {
				ball = stage.insert(new Q.Ball({target:-1}));
				player1 = stage.insert(new Q.Player1({vy:-40}));
				player2 = stage.insert(new Q.Player2());
			});
			
			Q.scene("move2", function(stage) {
				ball = stage.insert(new Q.Ball({target:1}));
				player1 = stage.insert(new Q.Player1({vy:-40}));
				player2 = stage.insert(new Q.Player2());
			});
			
			Q.gameLoop(function(dt) {
				Q.clear();

				ball.update(dt);
				player1.update(dt);
				player2.update(dt);

				if (player1.p.y <= ball.p.y + player1.p.h) {
					player1.p.vy = 0;
					ball.moveToTarget();
				}
				
				if (ball.p.y <= 100) {
					ball.stop();
					Q.clearStages();
				    Q.stageScene('endGame');
				}

				ball.render(Q.ctx);
				player1.render(Q.ctx);
				player2.render(Q.ctx);
				goal.render(Q.ctx);
			});

			Q.stageScene("move1");
		});
	</script>
</body>
</html>