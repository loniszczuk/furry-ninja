;Quintus.PenaltyKicksSprites = function(Q) {
	
	Q.gravityX = 0;
	Q.gravityY = 0;
	
	Q.Sprite.extend("Background",{
	  init: function(p) {
	    this._super(p,{
	      x: Q.width/2,
	      y: Q.height/2,
	      w: 790,
	      h: 720,
	      asset: 'background.png',
	      type: 0
	    });			
	  }
	});
	
	Q.Sprite.extend("Goal", {
		init : function (p) {
			this._super(p, {
				color : "black",
				w : 280,
				h : 20,
				x : Q.width/2 + 44,
				y : Q.height/2 - 200,
			});
			this.add("2d");
			this.on("hit", this, "collision");
		},
		draw : function(ctx) {
			ctx.fillStyle = "transparent";
			ctx.beginPath();
			ctx.fillRect(this.p.cx, -this.p.cy, -10, this.p.h + 50);
			ctx.fillRect(-this.p.cx, -this.p.cy, 10, this.p.h + 50);
			ctx.fillRect(-this.p.cx, -this.p.cy, this.p.w, this.p.h);
		},
		collision : function() {
			//stage.
			console.log("Something hit the Goal");
			Q.state.set("goal", true);
		} 
	});
	
	Q.MovingSprite.extend("AbstractBall", {
		stop : function() {
			this.p.vy = 0;
			this.p.vx = 0;
		},
		draw : function(ctx) {
			ctx.fillStyle = this.p.color;
			ctx.beginPath();
			ctx.arc(0, 0, this.p.w / 2, 0,
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
				x : Q.width/2 + 44,
				y : Q.height/2 + 220,
				ballPoints: [[-10,-10],[10,-10],[10,10],[-10,10]],
				
			});
			this.p.points = this.p.ballPoints;
			this.add("2d");
			console.log("Ball created");
			this.reset();
			
		},
		
		reset: function() {
			this.on("hit", this, "collision");
		},
		
		moveToGoal : function() {
			this.p.vy = -90;
			this.p.vx = 20 * this.p.direction;
		},
		
		collision: function(col) {
		  var msgLabel;
		  
		  console.log("Ball collision!")
		  if (col.obj.isA("Kicker")) {
			  console.log("Shoot!")
		  }else if (col.obj.isA("Goalie")) {
			  msgLabel = "Catch!";
			  console.log("Catch!")
		  }else if (col.obj.isA("Goal")) {
			  msgLabel = "Goal!";
			  console.log("Goal!")
		  }else {
			  console.log("Ooops!")
		  }
		  
		  if(Q.state.get("readyToKick")) {
			  console.log("moving ball!");
			  this.moveToGoal();
			  Q.state.set("readyToKick",false);
		  }else {
			  console.log("Ball moving, then stop")
			  this.stop();
			  this.off("hit", this, "collision");
			  if (Q.state.get("totalMoves") == Q.state.get("nextMove"))
				  Q.stageScene("gameEnded", 1);
			 else
				  Q.stageScene("nextMove",1, { label: msgLabel }); 
		  }
		},
	});
	
	Q.AbstractBall.extend("Kicker", {
		init : function(p) {
			this._super(p, {
				color : "red",
				w : 50,
				h : 50,
				x : Q.width/2 + 44,
				y : Q.height/2 + 300,
			});
			this.add("2d")
			this.on("hit", this, "collision");
		},
		collision: function(col) {
			console.log("Kicker shoots!");
			this.stop();
		}
	});
	
	Q.Sprite.extend("Goalie", {
		init : function(p) {
			this._super(p, {
				sheet: "goalie",
				sprite: "goalie",
				x : Q.width/2 + 44,
				y : Q.height/2 - 140,
				vy : 0,
				w : 90,
				h : 84,
				jump : false,
				scale : 1,
				standingPoints: [[-25,-40],[25,-40],[25,40],[-25,40]],
				jumpingPoints: [[-46,-20],[46,-20],[46,20],[-46,20]],
			});
			this.p.points = this.p.standingPoints;
			this.add("2d, animation");
			this.play("stand");
			this.on("hit", this, "collision");
			this.move();
		},
			
		step : function(dt) {
			if (this.p.vx != 0) {
				this.p.vx = this.p.vx + (-1 * this.p.direction);
			}else{
				this.p.jump = false;
			}
		},
	
		move : function() {
			if (this.p.vx == 0 && !this.p.jump) {
				this.p.jump = true;
				this.p.vx = 100 * this.p.direction
				if (this.p.direction > 0) {
					this.play("jump_right");
					this.p.points = this.p.jumpingPoints;
				}else if (this.p.direction < 0){
					this.play("jump_left");	
					this.p.points = this.p.jumpingPoints;
				}else if (this.p.direction == 0){
					this.play("stand");
					this.p.points = this.p.standingPoints;
				}
			}
		},
	
		stop : function() {
			this.p.vx = 0;
			this.p.vy = 0;
		},
		   
		collision: function(col) {
			;
		}
	});

};
