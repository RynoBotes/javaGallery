import { Component, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { BASE_API_URL } from 'src/environments/environment';
import { HomePage } from '../home/home.page';
import { ImageUploadPage } from '../image-upload/image-upload.page';
import { ImageViewPage } from '../image-view/image-view.page';


let Index = 1;
let availablePhotos = [];
let photos = [];

const imageId = document.getElementById("image");

fetch(BASE_API_URL+"photo-map/all")
.then(res =>
{
  return res.json();
}).then(loadedphotos =>
{  
  photos =  loadedphotos.payload.map( loadedphoto =>
  {
     const formattedPhoto = 
    {
      bloblocation: loadedphoto.bloblocation
    };
    for (var bloblocation in loadedphoto) 
    {
      availablePhotos.push(loadedphoto[bloblocation]);
      
    }
  });  
}).catch(err =>{
});
   
@Component({
  selector: 'app-gallery',
  templateUrl: './gallery.page.html',
  styleUrls: ['./gallery.page.scss'],
})
export class GalleryPage implements OnInit{
 public images = [];
 public image = ""; 

  constructor(private modalController:ModalController){}
  ngOnInit(): void {for (let index = 2; index < availablePhotos.length; index = index+6) 
   {
      const element = availablePhotos[index];
      let elementia = element.slice(63);
      this.images.push(elementia)
      
   }}
  // index.length = 0;
galleryLoad() {

      
     
     
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
