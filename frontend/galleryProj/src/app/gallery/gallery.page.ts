import { Component, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { HomePage } from '../home/home.page';
import { ImageUploadPage } from '../image-upload/image-upload.page';
import { ImageViewPage } from '../image-view/image-view.page';


let Index = 1;

const imageId = document.getElementById("image");

@Component({
  selector: 'app-gallery',
  templateUrl: './gallery.page.html',
  styleUrls: ['./gallery.page.scss'],
})
export class GalleryPage implements OnInit{
 public images = [];
 public image = ""; 

  constructor(private modalController:ModalController){}
  ngOnInit(): void {
  // index.length = 0;

  

  this.galleryLoad();
  // console.log(this.imagesPath);
  }
  galleryLoad(): String {
    for(var i = 1; i<14;i++)
      {
       this.images.push('../assets/images/'+i+'.JPG');
      
      }
      for(var j = 0; j<this.images.length;j++)
      {
        this.image =  this.images[j];
        console.log(this.image);
        return this.image;
      }
     
     
  }
  
  openPreview(index){
    this.modalController.create({
      component: ImageViewPage,
      cssClass:'modal-fullscreen',
      componentProps:{
        
        images: this.images,
        index: index
      }
    }).then(modal => modal.present());
  }





  back(){
   this.modalController.dismiss();
 }
 async home(){
  const modal = await this.modalController.create({
    component: HomePage,
    cssClass:'modal-fullscreen',
    id:'HomePage'
  });
  return await modal.present();
}
 
async upload(){
  const modal = await this.modalController.create({
    component: ImageUploadPage,
    cssClass:'modal-fullscreen',
    id:'Image-uploadPage'
  });
  return await modal.present();
}
  



}
