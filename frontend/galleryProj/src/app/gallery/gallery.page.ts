import { Component, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { HomePage } from '../home/home.page';

@Component({
  selector: 'app-gallery',
  templateUrl: './gallery.page.html',
  styleUrls: ['./gallery.page.scss'],
})
export class GalleryPage{

  constructor(private modalController:ModalController){}
  


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

}
