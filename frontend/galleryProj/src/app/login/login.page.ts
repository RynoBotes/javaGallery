import { Component } from '@angular/core';
import {  FormControl, FormGroup, Validators } from '@angular/forms';
import { ModalController, NavController, NavParams } from '@ionic/angular';
import { BASE_API_URL } from 'src/environments/environment';
import { GalleryPage } from '../gallery/gallery.page';

const username = document.getElementById("username");

let members = [];

fetch(BASE_API_URL+"/member-info/all")
.then(res =>{
  return res.json();
})
.then(loadedMembers =>{
  console.log(loadedMembers.payload);
  members = loadedMembers
})


@Component({
  selector: 'app-login',
  templateUrl: 'login.page.html',
  styleUrls: ['login.page.scss'],
})
export class LoginPage {

  myform: FormGroup;


  constructor(private modalController:ModalController , public navParams: NavParams){
    this.myform = new FormGroup({
      
        email: new FormControl('',Validators.email),
        password: new FormControl('',[Validators.required,Validators.minLength(6)])

      
    })
    }


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