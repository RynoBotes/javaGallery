(self.webpackChunkgalleryProj=self.webpackChunkgalleryProj||[]).push([[1168],{1168:(i,e,t)=>{"use strict";t.r(e),t.d(e,{ImageViewPageModule:()=>u});var s=t(8583),n=t(665),o=t(3083),r=t(649),l=t(3066),c=t(639);const a=[{path:"",component:l.v}];let d=(()=>{class i{}return i.\u0275fac=function(e){return new(e||i)},i.\u0275mod=c.oAB({type:i}),i.\u0275inj=c.cJS({imports:[[r.Bz.forChild(a)],r.Bz]}),i})(),u=(()=>{class i{}return i.\u0275fac=function(e){return new(e||i)},i.\u0275mod=c.oAB({type:i}),i.\u0275inj=c.cJS({imports:[[s.ez,n.u5,o.Pc,n.UX,d]]}),i})()},3066:(i,e,t)=>{"use strict";t.d(e,{v:()=>c});var s=t(639),n=t(3083),o=t(8583);const r=["slider"];function l(i,e){if(1&i&&(s.TgZ(0,"ion-slide"),s.TgZ(1,"div",8),s._UZ(2,"img",9),s.qZA(),s.qZA()),2&i){const i=e.$implicit;s.xp6(2),s.Q6J("src",i,s.LSH)}}let c=(()=>{class i{constructor(i,e){this.navParams=i,this.modalController=e,this.images=[],this.sliderOpts={initialSlide:1,zoom:{maxRatio:3}}}ngOnInit(){}back(){this.modalController.dismiss()}ionViewWillEnter(){this.sliderOpts.initialSlide=this.navParams.get("index"),this.images=this.navParams.get("images")}ionViewDidEnter(){this.slider.slideTo(this.sliderOpts.initialSlide,500,!0)}zoom(i){this.slider.getSwiper().then(e=>{let t=e.zoom;i?t.in():t.out()})}next(){console.log(this.slider),this.slider.slideNext(100)}prev(){this.slider.slidePrev()}close(){this.modalController.dismiss()}}return i.\u0275fac=function(e){return new(e||i)(s.Y36(n.X1),s.Y36(n.IN))},i.\u0275cmp=s.Xpm({type:i,selectors:[["app-image-view"]],viewQuery:function(i,e){if(1&i&&s.Gf(r,5),2&i){let i;s.iGM(i=s.CRH())&&(e.slider=i.first)}},decls:13,vars:2,consts:[["horizontal","end","slot","end",3,"click"],["fullscreen","",1,"modal-fullscreen"],["lines","none","text-center","",1,"close-fake"],[3,"options"],["slider",""],[4,"ngFor","ngForOf"],[1,"swiper-button-next",3,"click"],[1,"swiper-button-prev",3,"click"],[1,"swiper-zoom-container"],[3,"src"]],template:function(i,e){1&i&&(s.TgZ(0,"ion-header"),s.TgZ(1,"ion-toolbar"),s.TgZ(2,"ion-title"),s._uU(3,"ImageView"),s.qZA(),s.TgZ(4,"ion-button",0),s.NdJ("click",function(){return e.back()}),s._uU(5,"Back"),s.qZA(),s.qZA(),s.qZA(),s.TgZ(6,"ion-content",1),s._UZ(7,"ion-item",2),s.TgZ(8,"ion-slides",3,4),s.YNc(10,l,3,1,"ion-slide",5),s.qZA(),s.TgZ(11,"div",6),s.NdJ("click",function(){return e.next()}),s.qZA(),s.TgZ(12,"div",7),s.NdJ("click",function(){return e.prev()}),s.qZA(),s.qZA()),2&i&&(s.xp6(8),s.Q6J("options",e.sliderOpts),s.xp6(2),s.Q6J("ngForOf",e.images))},directives:[n.Gu,n.sr,n.wd,n.YG,n.W2,n.Ie,n.Hr,o.sg,n.A$],styles:[""]}),i})()}}]);