PrimeFaces.widget.SimpleDateFormat=Class.extend({init:function(a){this.cfg=a;this.cfg.regex=/('[^']*')|(G+|y+|M+|w+|W+|D+|d+|F+|E+|a+|H+|k+|K+|h+|m+|s+|S+|Z+)|([a-zA-Z]+)|([^a-zA-Z']+)/;this.cfg.TEXT2=0;this.cfg.TEXT3=1;this.cfg.NUMBER=2;this.cfg.YEAR=3;this.cfg.MONTH=4;this.cfg.TIMEZONE=6;this.cfg.types={G:this.cfg.TEXT2,y:this.cfg.YEAR,M:this.cfg.MONTH,w:this.cfg.NUMBER,W:this.cfg.NUMBER,D:this.cfg.NUMBER,d:this.cfg.NUMBER,F:this.cfg.NUMBER,E:this.cfg.TEXT3,a:this.cfg.TEXT2,H:this.cfg.NUMBER,k:this.cfg.NUMBER,K:this.cfg.NUMBER,h:this.cfg.NUMBER,m:this.cfg.NUMBER,s:this.cfg.NUMBER,S:this.cfg.NUMBER,Z:this.cfg.TIMEZONE};this.cfg.ONE_DAY=24*60*60*1000;this.cfg.ONE_WEEK=7*this.cfg.ONE_DAY;this.cfg.DEFAULT_MINIMAL_DAYS_IN_FIRST_WEEK=1;if(this.cfg.locale&&PrimeFaces.locales[this.cfg.locale]){this.cfg.monthNames=PrimeFaces.locales[this.cfg.locale].monthNames;this.cfg.dayNames=PrimeFaces.locales[this.cfg.locale].dayNames}else{this.cfg.monthNames=["January","February","March","April","May","June","July","August","September","October","November","December"];this.cfg.dayNames=["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"]}},newDateAtMidnight:function(b,c,a){var e=new Date(b,c,a,0,0,0);e.setMilliseconds(0);return e},getDifference:function(b,a){return b.getTime()-a.getTime()},isBefore:function(b,a){return b.getTime()<a.getTime()},getUTCTime:function(a){if(a!=undefined){return Date.UTC(a.getFullYear(),a.getMonth(),a.getDate(),a.getHours(),a.getMinutes(),a.getSeconds(),a.getMilliseconds())}},getTimeSince:function(b,a){return this.getUTCTime(b)-this.getUTCTime(a)},getPreviousSunday:function(a){var c=new Date(a.getFullYear(),a.getMonth(),a.getDate(),12,0,0);var b=new Date(c.getTime()-a.getDay()*this.cfg.ONE_DAY);return this.newDateAtMidnight(b.getFullYear(),b.getMonth(),b.getDate())},getWeekInYear:function(d,g){var e=this.getPreviousSunday(d);var b=this.newDateAtMidnight(d.getFullYear(),0,1);var f=this.isBefore(e,b)?0:1+Math.floor(this.getTimeSince(e,b)/this.cfg.ONE_WEEK);var a=7-b.getDay();var c=f;if(a<g){c--}return c},getWeekInMonth:function(b,g){var c=this.getPreviousSunday(b);var f=this.newDateAtMidnight(b.getFullYear(),b.getMonth(),1);var e=this.isBefore(c,f)?0:1+Math.floor((this.getTimeSince(c,f))/this.cfg.ONE_WEEK);var a=7-f.getDay();var d=e;if(a>=g){d++}return d},getDayInYear:function(b){var a=this.newDateAtMidnight(b.getFullYear(),0,1);return 1+Math.floor(this.getTimeSince(b,a)/this.cfg.ONE_DAY)},getMinimalDaysInFirstWeek:function(a){return this.cfg.minimalDaysInFirstWeek?this.cfg.DEFAULT_MINIMAL_DAYS_IN_FIRST_WEEK:this.cfg.minimalDaysInFirstWeek},format:function(u){var a="";var l;var e=function(x,w){while(x.length<w){x="0"+x}return x};var c=function(y,x,w){return(x>=4)?y:y.substr(0,Math.max(w,x))};var j=function(y,x){var w=""+y;return e(w,x)};var h=this.cfg.pattern;while((l=this.cfg.regex.exec(h))){var p=l[0];var k=l[1];var m=l[2];var g=l[3];var f=l[4];if(k){if(k=="''"){a+="'"}else{a+=k.substring(1,k.length-1)}}else{if(g){}else{if(f){a+=f}else{if(m){var b=m.charAt(0);var v=m.length;var n="";switch(b){case"G":n="AD";break;case"y":n=u.getFullYear();break;case"M":n=u.getMonth();break;case"w":n=this.getWeekInYear(u,this.getMinimalDaysInFirstWeek());break;case"W":n=this.getWeekInMonth(u,this.getMinimalDaysInFirstWeek());break;case"D":n=this.getDayInYear(u);break;case"d":n=u.getDate();break;case"F":n=1+Math.floor((u.getDate()-1)/7);break;case"E":n=this.cfg.dayNames[u.getDay()];break;case"a":n=(u.getHours()>=12)?"PM":"AM";break;case"H":n=u.getHours();break;case"k":n=u.getHours()||24;break;case"K":n=u.getHours()%12;break;case"h":n=(u.getHours()%12)||12;break;case"m":n=u.getMinutes();break;case"s":n=u.getSeconds();break;case"S":n=u.getMilliseconds();break;case"Z":n=u.getTimezoneOffset();break}switch(this.cfg.types[b]){case this.cfg.TEXT2:a+=c(n,v,2);break;case this.cfg.TEXT3:a+=c(n,v,3);break;case this.cfg.NUMBER:a+=j(n,v);break;case this.cfg.YEAR:if(v<=3){var d=""+n;a+=d.substr(2,2)}else{a+=j(n,v)}break;case this.cfg.MONTH:if(v>=3){a+=c(this.cfg.monthNames[n],v,v)}else{a+=j(n+1,v)}break;case this.cfg.TIMEZONE:var t=(n>0);var q=t?"-":"+";var s=Math.abs(n);var r=""+Math.floor(s/60);r=e(r,2);var o=""+(s%60);o=e(o,2);a+=q+r+o;break}}}}}h=h.substr(l.index+l[0].length)}return a}});PrimeFaces.widget.Clock=PrimeFaces.widget.BaseWidget.extend({init:function(a){this._super(a);this.cfg.pattern=this.cfg.pattern||"MM/dd/yyyy HH:mm:ss";this.cfg.dateFormat=new PrimeFaces.widget.SimpleDateFormat({pattern:this.cfg.pattern,locale:this.cfg.locale});this.current=this.isClient()?new Date():new Date(this.cfg.value);var b=this;if(this.isAnalogClock()){this.interval=setInterval(function(){b.update()},1000);this.draw()}else{this.start()}if(!this.isClient()&&this.cfg.autoSync){setInterval(function(){b.sync()},this.cfg.syncInterval)}},refresh:function(a){clearInterval(this.interval);this._super(a)},isClient:function(){return this.cfg.mode==="client"},start:function(){var a=this;this.interval=setInterval(function(){a.updateOutput()},1000)},stop:function(){clearInterval(this.interval)},updateOutput:function(){this.current.setSeconds(this.current.getSeconds()+1);this.jq.text(this.cfg.dateFormat.format(this.current))},sync:function(){if(!this.isAnalogClock()){this.stop()}var b=this,a={source:this.id,process:this.id,async:true,global:false,params:[{name:this.id+"_sync",value:true}],oncomplete:function(e,c,d){if(b.isAnalogClock()){b.current=new Date(d.datetime)}else{b.stop();b.current=new Date(d.datetime);b.jq.text(b.cfg.dateFormat.format(b.current));b.start()}}};PrimeFaces.ajax.Request.handle(a)},draw:function(){this.dimensions=this.getDimensions(this.jq.width());this.canvas=new Raphael(this.id,this.dimensions.size,this.dimensions.size);this.clock=this.canvas.circle(this.dimensions.half,this.dimensions.half,this.dimensions.clock_width);this.draw_hour_signs();this.draw_hands();this.pin=this.canvas.circle(this.dimensions.half,this.dimensions.half,this.dimensions.pin_width);this.clock.attr({fill:"#ffffff",stroke:"#4A4A4A","stroke-width":"3"});for(var a=0;a<this.hour_sign.length;a++){this.hour_sign[a].attr({stroke:"#000000","stroke-width":this.dimensions.hour_sign_stroke_width})}this.hour_hand.attr({stroke:"#4A4A4A","stroke-width":this.dimensions.hour_hand_stroke_width});this.minute_hand.attr({stroke:"#4A4A4A","stroke-width":this.dimensions.minute_hand_stroke_width});this.second_hand.attr({stroke:"#4A4A4A","stroke-width":this.dimensions.second_hand_stroke_width});this.pin.attr({fill:"#F58503"});this.update()},draw_hour_signs:function(){this.hour_sign=[];for(i=0;i<12;i++){(function(d,e){var c=e.dimensions.half+Math.round(e.dimensions.hour_sign_min_size*Math.cos(30*d*Math.PI/180));var b=e.dimensions.half+Math.round(e.dimensions.hour_sign_min_size*Math.sin(30*d*Math.PI/180));var a=e.dimensions.half+Math.round(e.dimensions.hour_sign_max_size*Math.cos(30*d*Math.PI/180));var f=e.dimensions.half+Math.round(e.dimensions.hour_sign_max_size*Math.sin(30*d*Math.PI/180));e.hour_sign.push(e.canvas.path("M"+c+" "+b+"L"+a+" "+f))})(i,this)}},draw_hands:function(){this.hour_hand=this.canvas.path("M"+this.dimensions.half+" "+this.dimensions.half+"L"+this.dimensions.half+" "+this.dimensions.hour_hand_start_position);this.minute_hand=this.canvas.path("M"+this.dimensions.half+" "+this.dimensions.half+"L"+this.dimensions.half+" "+this.dimensions.minute_hand_start_position);this.second_hand=this.canvas.path("M"+this.dimensions.half+" "+this.dimensions.half+"L"+this.dimensions.half+" "+this.dimensions.second_hand_start_position)},update:function(){this.hour_hand.animate({transform:"R"+(30*this.current.getHours()+(this.current.getMinutes()/2.5))+","+this.dimensions.half+","+this.dimensions.half},1);this.minute_hand.animate({transform:"R"+(6*this.current.getMinutes())+","+this.dimensions.half+","+this.dimensions.half},1);this.second_hand.animate({transform:"R"+(6*this.current.getSeconds())+","+this.dimensions.half+","+this.dimensions.half},1);this.current.setSeconds(this.current.getSeconds()+1)},getDimensions:function(a){return{size:a,half:Math.floor(a/2),clock_width:Math.floor(a*47.5/100),hour_sign_min_size:Math.floor(a*40/100),hour_sign_max_size:Math.floor(a*45/100),hour_sign_stroke_width:Math.floor(a*0.5/100)||1,hour_hand_start_position:Math.floor(a/4),hour_hand_stroke_width:Math.floor(a*3/100)||1,minute_hand_start_position:Math.floor(a/6),minute_hand_stroke_width:Math.floor(a*2/100)||1,second_hand_start_position:Math.floor(a*12.5/100),second_hand_stroke_width:Math.floor(a*1/100)||1,pin_width:Math.floor(a*2.5/100)}},isAnalogClock:function(){return this.cfg.displayMode==="analog"}});