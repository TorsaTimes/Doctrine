# ========== Build image ==========
FROM node:14-alpine AS BUILD_IMAGE

RUN apk update && apk add yarn curl bash && rm -rf /var/cache/apk/*
# install node-prune (https://github.com/tj/node-prune)
RUN curl -sfL https://install.goreleaser.com/github.com/tj/node-prune.sh | bash -s -- -b /usr/local/bin


# ========== Frontend ==========
WORKDIR /usr/src/app

COPY package.json yarn.lock ./

# install dependencies
RUN yarn --frozen-lockfile

# Bundle app source
COPY . .

# lint & test
# RUN yarn lint & yarn test

# build application
RUN yarn build


# ========== Fileserver ==========
WORKDIR /usr/src/app/fileserver

# install dependencies
RUN yarn --frozen-lockfile

# lint & test
# RUN yarn lint & yarn test

# build application
RUN yarn build

# remove development dependencies
RUN npm prune --production

# run node prune
RUN /usr/local/bin/node-prune



# ========== Final image ==========
FROM node:14-alpine

WORKDIR /usr/bin/app

COPY --from=BUILD_IMAGE /usr/src/app/fileserver/build ./build
COPY --from=BUILD_IMAGE /usr/src/app/fileserver/node_modules ./node_modules
COPY --from=BUILD_IMAGE /usr/src/app/fileserver/.env ./
COPY --from=BUILD_IMAGE /usr/src/app/build ./build/public

EXPOSE 29100
CMD [ "node", "./build/main.js" ]
