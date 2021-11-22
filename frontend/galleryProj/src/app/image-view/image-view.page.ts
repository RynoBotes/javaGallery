import { Component, OnInit, ViewChild } from '@angular/core';
import { IonSlides, ModalController, NavParams } from '@ionic/angular';

  @Component({
    selector: 'app-image-view',
    templateUrl: './image-view.page.html',
    styleUrls: ['./image-view.page.scss'],
  })
  export class ImageViewPage implements OnInit {
    public images = [];
  
    @ViewChild("slider", { static:false }) slider: IonSlides;
    sliderOpts = {
      initialSlide:1,
      zoom: {
        maxRatio: 3
      }
    };
  
    constructor(private navParams: NavParams, private modalController: ModalController) {}
    ngOnInit(): void {
  
    }
    back(){
      this.modalController.dismiss();
    }
  
    ionViewWillEnter() {
      this.sliderOpts.initialSlide= this.navParams.get('index');
      this.images= this.navParams.get('images');
    
    }
  
    ionViewDidEnter(){
      this.slider.slideTo(this.sliderOpts.initialSlide,500,true);
    }
  
    zoom(zoomIn : boolean){
       this.slider.getSwiper().then(swiper => { 
        let zoom = swiper.zoom;
      if(zoomIn){
        zoom.in();
      }else{
        zoom.out();
      }})
    }
  
   
    next() {
      console.log(this.slider);
      this.slider.slideNext(100);
    }
  
    prev() {
      this.slider.slidePrev();
    }
    close(){
      this.modalController.dismiss();
    }
  
  }
