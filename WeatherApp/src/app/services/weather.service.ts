import { HttpClient, HttpHeaderResponse, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environment/environment';
import { WeatherData } from '../models/weather.model';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {
//request
  constructor(private http: HttpClient) { }
//we have here a request            return type, as we return ->use return
  getWeatherData(cityName: string): Observable<WeatherData> {
    //pt a face call(fetch) ne trebuie, cum scrie pe site, url-u unde sa trimitem si queriu
    //mapping in WeatherData
    return this.http.get<WeatherData>(environment.weatherApiBaseUrl+'/city/'+cityName,{
      //2 headers 1-host,1-key scrise in environment.ts file
      headers: new HttpHeaders()//set the headers, 1 for host, 1 for key
      .set(environment.XRapidAPIHostHeaderName, environment.
        XRapidAPIHostHeaderValue)//name plus value
      .set(environment.XRapidAPIKeyHeaderName, environment.
        XRapidAPIKeyHeaderValue),
        // params: new HttpParams()//query params
        // .set('q', cityName)
        // .set('appid', 'da0f9c8d90bde7e619c3ec47766a42f4')
        // //.set('appid', 'da0f9c8d90bde7e619c3ec47766a42f4')
        // .set('units','standard')
        // //.set('mode', 'json')
        
//map to a model->weather.model.ts
    });
  }
}
