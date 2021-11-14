import { Component } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { GalleryPage } from '../gallery/gallery.page';

@Component({
  selector: 'app-login',
  templateUrl: 'login.page.html',
  styleUrls: ['login.page.scss'],
})
export class LoginPage {

  constructor(private modalController:ModalController){}


  back(){
   this.modalController.dismiss();
 }
 async gallery(){
  const modal = await this.modalController.create({
    component: GalleryPage,
    cssClass:'modal-fullscreen',
    id:'GalleryPage'
  });
  return await modal.present();
}
}