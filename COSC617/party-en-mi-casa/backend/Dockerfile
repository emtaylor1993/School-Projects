###############################################################
# DOCKERFILE
#
# @author Emmanuel Taylor
#
# @description
#   Provides a set of instructions for the creation of the
#   docker image for the application's back end.
###############################################################

# Build the Node.js application.
FROM docker.io/node:22

# Set the working directory inside the container.
WORKDIR /app/src

# Copy package.json and package-lock.json to the container.
COPY package*.json ./

# Installs dependencies using the lock file as a clean installation.
RUN npm ci

# Copy the rest of the application code to the container.
COPY . .

# Expose port 3002 for applications to listen on.
EXPOSE 3002

# Command to run the application.
CMD ["npm", "start"]