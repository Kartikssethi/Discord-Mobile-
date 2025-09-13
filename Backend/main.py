
# from fastapi import FastAPI, HTTPException
# from fastapi.middleware.cors import CORSMiddleware
# from supabase import create_client
# import os
# from dotenv import load_dotenv


# SUPABASE_URL = "https://qwqveqyksuksqnrjeoow.supabase.co"
# SUPABASE_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InF3cXZlcXlrc3Vrc3Fucmplb293Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTc3MzUwNTUsImV4cCI6MjA3MzMxMTA1NX0.TmFSJDOuWcKV1BTMUj0I9fAQJWZLR6As0RhWIsED7zM"
# supabase = create_client(SUPABASE_URL, SUPABASE_KEY)
# app = FastAPI()

# app.add_middleware(
#     CORSMiddleware,
#     allow_origins=["*"],
#     allow_credentials=True,
#     allow_methods=["*"],
#     allow_headers=["*"],
# )

# @app.post("/signup")
# def signup(email: str, password: str, role: str):
#     try:

#         auth_response = supabase.auth.sign_up({
#             "email": email,
#             "password": password
#         })
#         if "error" in auth_response and auth_response["error"]:
#             raise HTTPException(status_code=400, detail=auth_response["error"]["message"])
#         # Store role in Postgres table
#         user_id = auth_response.user.id
#         supabase.table("profiles").insert({
#             "id": user_id,
#             "role": role
#         }).execute()
#         return {"message": "User signed up successfully", "user_id": user_id, "role": role}
#     except Exception as e:
#         raise HTTPException(status_code=400, detail=str(e))




# @app.get("/hello")
# def read_hello():
#     return {"message": "Hello from FastAPI!"}


# @app.get("/users")
# def get_users():
#     response = supabase.table("users").select("*").execute()
#     return response.data


