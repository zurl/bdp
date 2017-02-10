/**
 * Created by zcy on 2017/2/9.
 */

export const server_url = "http://localhost:8080";


export const Network = {
    getURL : function( link ){
        return link.replace(/^[a-z]*:\/\/[^\/]*\//,'/');
    },
    getId : function ( obj ){
        const arr = obj["_links"]["self"]["href"].split('/');
        return arr[arr.length - 1];
    },
    get: function(resource, callback, error = ()=>{}) {
        fetch(server_url + resource, {method: 'GET'}).then(
            item => item.json().then(
                json => callback(json)
            )
        ).catch(error);
    },
    post: function(resource, payload, callback, error = ()=>{}) {
        fetch(server_url + resource, {
                headers : new Headers({
                    "Content-Type": "application/json"
                }),
                body: JSON.stringify(payload),
                method: 'POST'
            } ).then(
            item => item.json().then(
                json => callback(json)
            )
        ).catch(error);
    },
    put: function(resource, payload, callback, error = ()=>{}) {
        fetch(server_url + resource, {
            headers : new Headers({
                "Content-Type": "application/json"
            }),
            body: JSON.stringify(payload),
            method: 'PUT'
        } ).then(
            item => item.json().then(
                json => callback(json)
            )
        ).catch(error);
    },
    del: function(resource, callback, error = ()=>{}) {
        fetch(server_url + resource, { method: 'DELETE' } ).then(
           callback
        ).catch(error);
    }
};
