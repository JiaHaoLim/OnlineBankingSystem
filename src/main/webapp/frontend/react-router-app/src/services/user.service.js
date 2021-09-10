import http from "../http-common";

class UserDataService {
    getAll() {
        //GET http://localhost:9090/users
        return http.get("/users");
    }

    get(id) {
        return http.get(`/users/${id}`);
    }

    create(data) {
        return http.post("/users", data);
    }
    
    update(id, data) {
        return http.put(`/users/${id}`, data);
    }
    
    delete(id) {
        return http.delete(`/users/${id}`);
    }
    
    deleteAll() {
        return http.delete(`/users`);
    }
    
    findByName(name) {
        return http.get(`/users/name/${name}`);
    }
  
}

export default new UserDataService();
